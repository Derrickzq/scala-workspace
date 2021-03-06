

Bigtable是一个分布式存储系统，管理能够拓展的（达到在数以千计的服务器，处理PB级别的）结构化数据。Google的很多项目都存储在Bigtable中， 包括web indexing，Google Earth, 和Google Finance.  这些形形色色的应用对于Bigtable提出了很多需求，既有对于数据大小方面（从URLs 到网页界面，到卫星图像）， 也有对于延迟要求（从后端批量处理到实时数据服务）。尽管多种要求， Bigtable还是为所有的Google 产品成功提供了快捷、高效的解决方案。在本文中，我们将描述一些Bigtable提供的简单模型，用于控制数据的表达和形式，同时我们将描述关于Bigtable的设计和实现过程。

# 1. Introduction

​	**在过去的两年半中，我们设计、实现并部署了分布式存储系统Bigtable，用于管理Google结构化数据的工具。 Bigtable旨在可靠地扩展至PB级数据和数千台机器为其提供服务。 Bigtable已达成几个目标：广泛的适用性，可扩展性，高性能和高可用性。 Bigtable被用于六十多种Google产品和项目，包括Google Analytics，Google财经，Orkut，Person搜索，Writely和Google Earth。这些产品将Bigtable用于各种要求苛刻的工作负载下，从针对吞吐量进行优化的批处理作业，到提供延迟敏感的数据给终端。这些产品使用的Bigtable集群涵盖了广泛的领域一系列配置，从少数到数千台服务器，并存储多达数百TB的数据。**
​	**在许多方面，Bigtable在很多方面类似于数据库：它共享数据库的许多实践策略。 并行式数据库[14]和主存储器数据库[13]已经具有不错的扩展性和高性能，但是Bigtable提供了一种异于其他系统的交互方式。**

​	**Bigtable不支持完整的关系数据模型；相反，它为客户提供支持的简单数据模型，用于动态控制数据布局和格式，并允许客户推理基础存储中表示的数据的局部性。数据使用行和列的名称（可以使任意的字符串）进行索引。Bigtable还会将数据视为未解释的字符串，尽管客户通常会序列化各种形式的结构化和半结构化的数据放入这些字符串中。客户可以通过模式选择，控制其数据的位置。最后，Bigtable模式参数可让客户动态控制是否服务超出内存或来自磁盘数据。**

​	第二部分描述数据模型，第三部分简述客户API，第四部分描述Bigtable所依赖的Google基础设施，第五部分描述Bigtable的实现基础，第六部分部分细节我们用于提升Bigtable的性能。第七部分测度Bigtable的性能，描述了几个Google的用例。第八部分讨论一些设计和支持Bigtable时遇到的教训。最后，第十部分描述相关的工作，第十一部分给出我们的结论

# Data Model

Bigtable是一个稀疏的，分布式的，持续的多维排序映射。该映射按**行键**，**列键**和**时间戳**编制索引；映射中的每个值都是未解释的字节数组。
$$
(row:string, column:string, time:int64) → string
$$

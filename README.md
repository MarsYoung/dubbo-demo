# dubbo-demo
为了熟悉dubbo框架的使用，看了些dubbo的文档，决定实践一下，搭建一个简单的dubbo服务。
大概的想法是：使用spring管理dubbo，注册中心使用zookeeper，使用maven 配置和管理项目，分为3部分，服务提供端弄三个Project，一个叫做dubbo-demo用作父Project来管理整个 Projects，一个叫做dubbo-demo-api的 Project用来定义服务接口，一个叫做dubbo-demo-core的 Project用来定义和配置dubbo服务提供者，一个叫dubbo-demo-use的 Project来实现服务的使用。
由于我只有一台512M的阿里云 ubuntu服务器，所以暂时不考虑多注册中心，正好我几天前，搭建了zookeeper，所以目前我只需要新建几个maven项目，并且添加一些简单的配置即可实现我上面的想法。
工程之后同步到git上（http://github.com/MarsYoung/dubbo-demo），以后可以参考学习。


1.新建maven项目.在eclipse中打开new,选择others，并且在搜索框中输入maven。（前提是我的机器eclipse中已经安装了maven插件。）


2.选择maven-archetype-quickstart架构的maven项目类型。


3.输入对应的组织ID和项目ID,定义独特的包名，然后点击finish完成父项目的搭建。


4.新建New Project，选择Maven Module。

5. 新建dubbo-demo-api项目用来定义接口。

6.新建的时候会提示错误，因为Maven Module的新建需要选用Parent Project，而ParentProject中要求有pom类型的packaging。

7.打开刚才新建的dubbo-demo 工程的pom文件，修改packaging节点为pom类型。


8. 然后可以新建dubbo-dem-api,dubbo-demo-service等Project，选中dubbo-demo作为Parent Project.


9.这样maven插件会在dubbo-demo的pom文件中自动生成Modules的节点。



10.同时在新建的工程中，有了parent节点，指向dubbo-demo 工程。


11.而dubbo-demo 工程的目录结构看起来是这个样子。


12.在github网站上create repository  名称为dubbo-demo
git init
git add *
git commit -m "init project"
git remote add origin git@github.com:MarsYoung/dubbo-demo
git push -u origin master

13.删除eclipse中项目，本地不删除，然后再重新导入maven项目，eclipse自动识别git项目（记不清git插件是自带的还是我之前装的了）。
  

14.工程建好之后就该具体配置dubbo和zookeeper的使用了，首先在dubbo-demo的pom中指定整个项目使用的zookeeper和dubbo版本，以及ZKclient的版本，以及spring的版本。

其中dubbo中由于使用了spring的相关依赖，zookeeper中使用了jmx等的相关依赖，所以用exclusions把对应的依赖删除，使用项目内部的依赖，使依赖统一。
然后配置core项目的pom，添加dubbo，zookeeper，zkclient等依赖。
对dubbo-demo-api执行maven install，之后在core项目中添加入dependency。

并且maven update project，之后新建对应的包，类实现一个在console打印hello的功能。



15。然后要配置spring，但是找不到对应的source folder，新建一个。


16. core的 pom中引入 spring，加入dubbo标签，并且按照dubbo文档配置相关内容，如下。

17. 为了让dubbo-demo-core工程打包成一个可执行jar,我用来maven-shade-plugin插件，指定了对应的要运行的类。


打包，结果报异常说无法找到api包，install api包后还是无法找到，奇怪啊，后来把lastupdate文件删除之后才找到。。

18.打包成功后把对应的jar包提交到服务器上，然后执行java -jar jar包。第一次忘了引入zkclient的依赖，报下列错误。


19.引入zkClient之后启动成功。




20.通过zookeeper的管理平台（上一篇文章中用来测试dubbo源码中的示例服务搭建的），可以查看对应提供的服务。至此dubbo服务搭建完成。
这样对于我们系统中的其他工程就可以通过dubbo来使用zookeeper注册中心提供的工程。

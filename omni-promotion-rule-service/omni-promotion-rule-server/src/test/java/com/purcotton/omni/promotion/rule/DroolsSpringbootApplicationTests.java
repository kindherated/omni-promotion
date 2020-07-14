package com.purcotton.omni.promotion.rule;
import com.google.gson.Gson;
import com.purcotton.omni.promotion.rule.bean.*;
import com.purcotton.omni.promotion.rule.model.Input;
import com.purcotton.omni.promotion.rule.model.InputItem;
import com.purcotton.omni.promotion.rule.model.Output;
import com.purcotton.omni.promotion.rule.model.OutputItem;
import com.purcotton.omni.promotion.rule.service.RuleTableService;
import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.drools.decisiontable.ExternalSpreadsheetCompiler;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.drools.template.ObjectDataCompiler;
import org.junit.Test;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

import java.io.*;
import java.util.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DroolsSpringbootApplicationTests {

//    @Autowired
	private RuleTableService ruleTableService;

//    @Autowired
    private KieHelper kieHelper = new KieHelper();

    //https://zhuanlan.zhihu.com/p/32867169
	/**
	 * date-expires  系统时间<date-expires,规则才会触发执行
	 * date-effective 系统时间>=date-effective,规则才会触发执行
	 */
	@Test
	public void expiresEffectiveTest() {
		String format = "yyyy-MM-dd"; //"dd-MM-yyyy"
		System.setProperty("drools.dateformat", format); //指定日期格式，不然会出现日期转换报错
		//加载drl文件到规则库
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/date.drl"), ResourceType.DRL);
		//创建会话
		KieSession kieSession = kieHelper.build().newKieSession();
		//执行规则
		int count = kieSession.fireAllRules();
		System.out.println("总共有count："+count+"条规则被匹配");
		//清理session状态,释放资源
		kieSession.dispose();
	}

	/**
	 * no-loop不设置noloop的效果
	 */
	@Test
	public void noLoopTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/noloop.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		Person p = new Person();
		p.setName("张三");
		//插入Fact到工作内存
		kieSession.insert(p);
		int count = kieSession.fireAllRules();
		System.out.println("总共有count："+count+"条规则被匹配");
		kieSession.dispose();
	}

	/**
	 * 设置noloop的效果
	 */
	@Test
	public void noLoop1Test() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/noloop1.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		Person p = new Person();
		p.setName("张三");
		kieSession.insert(p);
		int count = kieSession.fireAllRules();
		System.out.println("总共有count："+count+"条规则被匹配");
		kieSession.dispose();
	}

	/**
	 * 设置noloop的效果
	 */
	@Test
	public void noLoop2Test() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/noloop2.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		Person p = new Person();
		p.setName("张三");
		kieSession.insert(p);
		int count = kieSession.fireAllRules();
		System.out.println("总共有count："+count+"条规则被匹配");
		kieSession.dispose();
	}

	/**
	 * salience
	 * 用来设置规则的优先级，salience属性值是一个数字，数字越大优先级越高，
	 * 优先级高的最先被执行，同时它也可以是一个负数，默认值为0
	 * 不设置则随机，数值相同，顺序执行
	 */
	@Test
	public void salienceTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/salience.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		int count = kieSession.fireAllRules();
		System.out.println("总共有count："+count+"条规则被匹配");
		kieSession.dispose();
	}


	/**
	 * enabled: 用来定义规则是否可用，默认为true
	 * 设置为false，则规则不启用
	 */
	@Test
	public void enableTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/enable.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		int count = kieSession.fireAllRules();
		System.out.println("总共有count："+count+"条规则被匹配");
		kieSession.dispose();
	}

	/**
	 * duration已被timer取代这里我们主要看timer
	 * 定时器
	 */
	@Test
	public void durationTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/duration.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		//kieSession.fireAllRules();
		kieSession.fireUntilHalt();
		int count = kieSession.fireAllRules();
		System.out.println("总共有count："+count+"条规则被匹配");
		System.out.println("current thread id:"+Thread.currentThread().getId());
	}


	/**
	 * and or语法介绍
	 */
	@Test
	public void andorTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/andor.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		Person p = new Person(10,"张三","测试","男");
		kieSession.insert(p);
		kieSession.fireAllRules();
		System.out.println(p);

		Person p1 = new Person(30,"张三","测试","男");
		kieSession.insert(p1);
		kieSession.fireAllRules();
		System.out.println(p1);

		Person p2 = new Person(60,"张三","测试","男");
		kieSession.insert(p2);
		kieSession.fireAllRules();
		System.out.println(p2);

		Person p3 = new Person(70,"李四","测试","女");
		kieSession.insert(p3);
		int count = kieSession.fireAllRules();
		System.out.println("总共有count："+count+"条规则被匹配");
		kieSession.dispose();
		System.out.println(p3);
	}

	/**
	 * compare语法测试(memberOf\not memberOf\contains\not contains\matches)
	 */
	@Test
	public void compareTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/compare.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		Person p = new Person(10,"李三","测试","男");
		p.setHobbies(Arrays.asList("唱歌","吃饭"));
		kieSession.insert(p);
		int count = kieSession.fireAllRules();
		System.out.println("匹配执行了count："+count+"条规则");
		System.out.println(p);
	}

	/**
	 * activation-group: 将若干规则分成一个组，用字符串来给组命名
	 * 具有相同activation-group属性的规则中只有一个会被执行
	 */
	@Test
	public void activationGroupTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/activationgroup.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		int count = kieSession.fireAllRules();
		System.out.println("总共有count："+count+"条规则被匹配");
		kieSession.dispose();
	}

	/**
	 * activation-group: 将若干规则分成一个组，用字符串来给组命名
	 * 具有相同activation-group属性的规则中只有一个会被执行
	 * 问：会被执行几次
	 */
	@Test
	public void activationGroup1Test() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/activationgroup1.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		Person p = new Person(20,"张三","张三");
		Person p1 = new Person(20,"李四","李四");
		kieSession.insert(p);
		kieSession.insert(p1);
		int count = kieSession.fireAllRules();
		System.out.println("总共执行了count："+count+ "条规则");
		System.out.println(p);
		System.out.println(p1);
		kieSession.dispose();
	}

	/**
	 * 1. 如果没有指定agenda-group 则默认把所有未指定agenda-group的 rules 都执行一遍
	 * 2. 如果指定了agenda-group 使用的时候必须指定该name才能被使用，默认是不能使用的
	 * 3. agenda-group name可以重复
	 * 4. agenda-group 用于区分rule
	 */
	@Test
	public void agendaGroupTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/agendagroup.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		//如果不设置指定AgendaGroup获得焦点，则该AgendaGroup下的规则将不会被执行
//		kieSession.getAgenda().getAgendaGroup("abc").setFocus();
		Person p = new Person(20,"张三","张三");
		kieSession.insert(p);
		int count = kieSession.fireAllRules();
		System.out.println("匹配执行了count："+count+"条规则");
		kieSession.dispose();
	}


	/**
	 * 一般跟agenda-group搭配使用,将属性值设置为true，则规则只会被执行一次，
	 * 避免某些fact对象被修改以后规则被重新激活执行
	 * 锁定激活,理解为当fact被激活时，该规则不生效
	 */
	@Test
	public void lockOnActiveTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/lockOnActive.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		Person p = new Person();
		p.setName("张三");
		kieSession.insert(p);
		int count = kieSession.fireAllRules();
		System.out.println("匹配执行了count："+count+"条规则");
		kieSession.dispose();
	}


	/**
	 * 用途：是将一个Fact对象插入到working memory中
	 * 注意: 一旦调用insert函数，drools会重新匹配所有的规则，对于没有设置no-loop属性的规则如果满足条件都会再重新执行一次
	 * 同理也适用于update/modify,retrace/delete等宏函数
	 */
	@Test
	public void insertTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/insert.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		int count = kieSession.fireAllRules();
		System.out.println("匹配执行了count："+count+"条规则");
		kieSession.dispose();
	}


	/**
	 * 用途：是将一个Fact对象插入到working memory中
	 * 注意: 一旦调用insert函数，drools会重新匹配所有的规则，对于没有设置no-loop属性的规则如果满足条件都会再重新执行一次
	 * 同理也适用于update/modify,retrace/delete等宏函数
	 */
	@Test
	public void retractTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/retract.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		Person p = new Person();
		p.setName("张三");
		p.setAge(50);
		kieSession.insert(p);
		int count = kieSession.fireAllRules();
		System.out.println("匹配执行了count："+count+"条规则");
		kieSession.dispose();
	}

	/**
	 * 集合测试(List,set,map)
	 */
	@Test
	public void collection1Test() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/collection1.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		List<String> list = (Arrays.asList("唱歌","跳舞"));
		kieSession.insert(list);
		Set<String> set = new HashSet<String>() {{
			add("英语");
			add("数学");
		}};
		kieSession.insert(set);
		Map<String,Object> map = new HashMap<String,Object>(){{
			put("班级1","1");
			put("班级2","2");
		}};
		kieSession.insert(map);
		int count = kieSession.fireAllRules();
		System.out.println("匹配执行了count："+count+"条规则");
		kieSession.dispose();
	}

	/**
	 * JAVABEAN集合测试(List,set,map)
	 */
	@Test
	public void collection2Test() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/collection2.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		Person p = new Person();
		p.setName("张三");
		p.setAge(50);
		p.setHobbies(Arrays.asList("唱歌","跳舞"));
		p.setTestSet(new HashSet<String>() {{
			add("英语");
			add("数学");
		}});
		p.setTestMap(new HashMap<String,Object>(){{
			put("班级1","1");
			put("班级2","2");
		}});
		//实例化一个List，并插入到工作内存中
		FactHandle insert = kieSession.insert(p);
		int count = kieSession.fireAllRules();
		System.out.println("匹配执行了count："+count+"条规则");
		kieSession.dispose();
	}

	/**
	 * global全局变量定义成常量或者包装类型(Integer,Long,Short.....)时，该值对整个规则而言是不变的;
	 * global定义成javabean和集合类时，规则体对RHS进行修改，则规则库和Java代码里面的值会发生变化
	 */
	@Test
	public void globalTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/global.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		//实例化一个List，并插入到工作内存中
		kieSession.setGlobal("count",100);
		kieSession.setGlobal("list",new ArrayList<String>());
		kieSession.setGlobal("ruleTableService",ruleTableService); //调用service的方式可以采用这种
		int count = kieSession.fireAllRules();
		System.out.println("匹配执行了count："+count+"条规则");
		kieSession.dispose();
	}

	/**
	 * query查询(不带参数)
	 */
	@Test
	public void queryTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/query.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		Person p1 = new Person(30,"张三","测试","男");
		kieSession.insert(p1);
		Person p2 = new Person(60,"张三","测试","男");
		kieSession.insert(p2);
		Person p3 = new Person(70,"李四","测试","女");
		kieSession.insert(p2);
		QueryResults queryResults = kieSession.getQueryResults("query age is 30"); //名字必须跟drl里面定义的一致
		for (QueryResultsRow row: queryResults) {
			Person p = (Person) row.get("person"); //名字必须跟drl里面的定义一致
			System.out.println("符合条件的记录数："+p.getName());
		}
		kieSession.dispose();
	}

	/**
	 * query查询(带参数)
	 */
	@Test
	public void queryParamTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/query1.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		Person p1 = new Person(30,"张三","测试","男");
		Person p2 = new Person(60,"张三","测试","男");
		Person p3 = new Person(70,"李四","测试","女");
		kieSession.insert(p2);
		kieSession.insert(p1);
		kieSession.insert(p3);
		Object[] objects = new Object[]{"张三","30"};
		//条件：查询名字为张三，年龄为30的数据
		QueryResults queryResults = kieSession.getQueryResults("query age is 30",objects); //名字必须跟drl里面定义的一致
		System.out.println("符合条件的记录数："+queryResults.size());
		for (QueryResultsRow row: queryResults) {
			Person p = (Person) row.get("person"); //名字必须跟drl里面的定义一致
			System.out.println("符合条件的记录数："+p.getName());
		}
		kieSession.dispose();
	}


	/**
	 * function(drl内部调用function)
	 */
	@Test
	public void functionTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/function.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		kieSession.fireAllRules();
		kieSession.dispose();
	}



	/**
	 * function(调用java方法)
	 */
	@Test
	public void function1Test() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/function1.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		kieSession.fireAllRules();
		kieSession.dispose();
	}

	/**
	 * declare
	 */
	@Test
	public void declareTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/declare.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		kieSession.fireAllRules();
		kieSession.dispose();
	}

	/**
	 * declare测试类同名的问题
	 */
	@Test
	public void declare1Test() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/declare1.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		kieSession.fireAllRules();
		kieSession.dispose();
	}

	/**
	 * declare测试类继承的问题
	 */
	@Test
	public void declare2Test() {
		KieHelper kieHelper = new KieHelper();
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/declare2.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		kieSession.fireAllRules();
		kieSession.dispose();
	}

	/********************************when规则demo开始*************************************/
	/**
	 * when条件LHS(left hand side)之in和not in举例说明
	 */
	@Test
	public void whenInNotTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/when_in_not.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();

		School s = new School();
		s.setClassName("二班");
		kieSession.insert(s);

		Student s1 = new Student();
		s1.setClassName("二班");
		s1.setName("张三");
		kieSession.insert(s1);

		Student s2 = new Student();
		s2.setClassName("三班");
		s2.setName("李四");
		kieSession.insert(s2);

		kieSession.fireAllRules();
		kieSession.dispose();
	}

	/**
	 * when条件LHS(left hand side)之not和exist举例说明
	 * exists用于判断符合条件的fact是否存在
	 */
	@Test
	public void whenNotExistsTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/when_not_exists.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();

		School s = new School();
		s.setClassName("二班");
		s.setName("二班");
		//通过方法来控制是否存在工作内存中
		kieSession.insert(s);

		kieSession.fireAllRules();
		kieSession.dispose();
	}

	/**
	 * when条件LHS(left hand side)之forall举例说明
	 * forall用于判断是否所有的fact都满足条件
	 */
	@Test
	public void whenForAllTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/when_forall.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		Person p = new Person(30,"张三","测试","男");
		kieSession.insert(p); //通过方法来控制是否存在工作内存中
		kieSession.fireAllRules();
		kieSession.dispose();
	}

	/**
	 * when条件LHS(left hand side)之from举例说明
	 * from 允许指定数据源进行过滤匹配
	 */
	@Test
	public void whenFromTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/when_from.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		Student s1 = new Student();
		s1.setName("张三");
		s1.setSchool(new School("二班","二班"));
		kieSession.insert(s1);

		Student s2 = new Student();
		s2.setName("李四");
		s2.setSchool(new School("一班","一班"));
		kieSession.insert(s2);

		kieSession.insert(new School()); //传入shcool对象
		int count = kieSession.fireAllRules();
		System.out.println("总共执行count："+count+"条规则");
		kieSession.dispose();
	}

	/**
	 * when条件LHS(left hand side)之from举例说明
	 * from 允许指定数据源进行过滤匹配
	 */
	@Test
	public void whenFrom1Test() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/when_from1.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();

		Student s1 = new Student();
		s1.setName("张三");
		s1.setClassName("二班");

		Student s2 = new Student();
		s2.setName("李四");
		s2.setClassName("一班");

		School s = new School();
		List<Student> classNameList = new ArrayList<Student>();
		classNameList.add(s1);
		classNameList.add(s2);
		s.setClassNameList(classNameList);
		kieSession.insert(s);

		int count = kieSession.fireAllRules();
		System.out.println("总共执行count："+count+"条规则");
		kieSession.dispose();
	}


	/**
	 * when条件LHS(left hand side)之collect举例说明
	 * collect 将所有符合条件的数据放入到一个数据集合中
	 */
	@Test
	public void whenCollectTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/when_collect.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();

		Student s1 = new Student();
		s1.setName("张三");
		s1.setClassName("二班");
		kieSession.insert(s1);

		Student s2 = new Student();
		s2.setName("李四");
		s2.setClassName("一班");
		kieSession.insert(s2);


		Student s3 = new Student();
		s3.setName("王五");
		s3.setClassName("一班");
		kieSession.insert(s3);

		int count = kieSession.fireAllRules();
		System.out.println("总共执行count："+count+"条规则");
		kieSession.dispose();
	}
	/**
	 * when条件LHS(left hand side)之accumulate举例说明
	 * accumulate由4部分组成
	 * 1.init初始化变量
	 * 2.action每次遍历执行的动作
	 * 3.reverse(可选)反转动作
	 * 4.result 返回的执行结果
	 */
	@Test
	public void whenAccmulateTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/when_accumulate.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();

		Student s1 = new Student();
		s1.setName("张三");
		s1.setClassName("二班");
		s1.setAge(18);
		kieSession.insert(s1);

		Student s2 = new Student();
		s2.setName("李四");
		s2.setClassName("一班");
		s2.setAge(19);
		kieSession.insert(s2);

		Student s3 = new Student();
		s3.setName("王五");
		s3.setClassName("一班");
		s3.setAge(20);
		kieSession.insert(s3);

		int count = kieSession.fireAllRules();
		System.out.println("总共执行count："+count+"条规则");
		kieSession.dispose();
	}


	/**
	 *when条件LHS(left hand side)之do then举例说明
	 */
	@Test
	public void whenDoThenTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/when_do_then.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();

		Student s1 = new Student();
		s1.setName("张三");
		s1.setClassName("二班");
		s1.setAge(18);
		kieSession.insert(s1);

		Student s2 = new Student();
		s2.setName("李四");
		s2.setClassName("二班");
		s2.setAge(18);
		kieSession.insert(s2);

		int count = kieSession.fireAllRules();
		System.out.println("总共执行count："+count+"条规则");
		kieSession.dispose();
	}
	/********************************when规则demo结束*************************************/

	/**
	 * 规则继承extends
	 */
	@Test
	public void extendsTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/extends.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();

		Student s1 = new Student();
		s1.setName("张三");
		s1.setClassName("二班");
		s1.setAge(18);
		kieSession.insert(s1);

		int count = kieSession.fireAllRules();
		System.out.println("总共执行count："+count+"条规则");
		kieSession.dispose();
	}

	/**
	 * halt方法测试
	 * 调用此方法会终止规则执行
	 */
	@Test
	public void haltTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/halt.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		Person p = new Person();
		p.setName("张三");
		p.setAge(20);
		kieSession.insert(p);
		int count = kieSession.fireAllRules();
		kieSession.dispose();
	}

	/**
	 * invoke
	 * 调用指定的规则名称
	 */
	@Test
	public void invokeRuleTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/invoke.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		Person p = new Person();
		p.setName("张三");
		p.setAge(20);
		kieSession.insert(p);
//		int count = kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("rule1"));
//		int count = kieSession.fireAllRules(new RuleNameEndsWithAgendaFilter("1"));
		int count = kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("rule"));
//		int count = kieSession.fireAllRules(new RuleNameMatchesAgendaFilter("^[a-z0-9A-Z]+$"));
		System.out.println("总共执行了count："+count+"条规则");
		kieSession.dispose();
	}


	/**
	 * 决策表demo举例说明
	 * RuleSet：定义包名
	 * Import：指定导入的class，包括类方法
	 * Variables：指定全局变量
	 * Notes：输入任何内容
	 * Functions：本地方法
	 * RuleTable 部分
	 * CONDITION：指定单个规则的条件
	 * ACTION：指定rule的结果
	 * PRIORITY：指定rule的 salience属性
	 * No-loop：指定rule的no-loop熟悉
	 *
	 * 使用场景:
	 * 如果规则能够被表达为模板+数据的格式，那你应该考虑使用决策表,
	 * 决策表中的每一行就是对应模板的一行数据，将产生一个规则
	 */
	@Test
	public void ruleTableTest() {
		//第一种方式
		SpreadsheetCompiler compiler = new SpreadsheetCompiler();
		//进行编译
		String rules = compiler.compile(ResourceFactory.newClassPathResource("rules/tables" + File.separator + "rule.xlsx", "UTF-8"), "rule-table");
		System.out.println("解析以后的规则为：");
		System.out.println(rules);
		kieHelper.addContent(rules,ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		Person p = new Person("Tony");
		kieSession.insert(p);
		int count = kieSession.fireAllRules();
		System.out.println("总共执行了count："+count+"条规则");
		kieSession.dispose();

		//第二种方式
//		SpreadsheetCompiler compiler = new SpreadsheetCompiler();
//		Resource resource = new ClassPathResource("tables" + File.separator + "rule.xlsx");
//		File sourceFile = resource.getFile();
//		InputStream inputStream = new FileInputStream(sourceFile);
//		String rules = compiler.compile(inputStream, "rule-table");
//		System.out.println(rules);

	    //第三种方式
//		SpreadsheetCompiler compiler = new SpreadsheetCompiler();
//		File f = new File("D:\\workspace\\dev\\drools-springboot-test\\rule-engine\\rule-engine-service\\src\\main\\resources\\tables\\rule.xlsx");
//		InputStream inputStream = new FileInputStream(f);
//		String rules = compiler.compile(inputStream,"rule-table");
//		System.out.println(rules);
	}


	/**
	 * 决策表demo举例说明 - 芝麻积分
	 */
	@Test
	public void ruleTable1Test() {
		SpreadsheetCompiler compiler = new SpreadsheetCompiler();
		//进行编译
		String rules = compiler.compile(ResourceFactory.newClassPathResource("rules/tables" + File.separator + "score.xlsx", "UTF-8"), "rule-table");
		System.out.println("解析以后的规则为：");
		System.out.println(rules);
		kieHelper.addContent(rules,ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		Score s = new Score();
		s.setAge(24);
		s.setGender(0);
		s.setZmScore(652);
		kieSession.insert(s);
		int count = kieSession.fireAllRules();
		System.out.println("总共执行了count："+count+"条规则");
		System.out.println(s);
		kieSession.dispose();
	}

	/**
	 * 决策表demo举例说明 - 芝麻积分2
	 */
	@Test
	public void ruleTable2Test() {
		SpreadsheetCompiler compiler = new SpreadsheetCompiler();
		//进行编译
		String rules = compiler.compile(ResourceFactory.newClassPathResource("rules/tables" + File.separator + "score1.xlsx", "UTF-8"), "rule-table");
		System.out.println("解析以后的规则为：");
		System.out.println(rules);
		kieHelper.addContent(rules,ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		kieSession.setGlobal("var","20");
		kieSession.getAgenda().getAgendaGroup("GROUP1").setFocus();
		Score s = new Score();
		s.setAge(24);
		s.setGender(0);
		s.setZmScore(652);
		kieSession.insert(s);
		int count = kieSession.fireAllRules();
		System.out.println("总共执行了count："+count+"条规则");
		System.out.println(s);
		kieSession.dispose();
	}


	/**
	 * 规则模板之excel初始化数据(drl+xls构造drl规则)
	 * 参考：http://www.javaear.com/question/45918759.html
	 */
	@Test
	public void ruleTemplateTest() throws IOException {
		ExternalSpreadsheetCompiler converter = new ExternalSpreadsheetCompiler();
		String drl = converter.compile(
				//指定excel
				ResourceFactory.newClassPathResource("rules/template" + File.separator + "template.xlsx", "UTF-8").getInputStream(),
				//指定drl模板
				ResourceFactory.newClassPathResource("rules/template" + File.separator + "template.drl", "UTF-8").getInputStream(),
			    2, //从第几行开始读数据
				1); //从第几列开始读数据
		System.out.println("解析以后的规则为：");
		System.out.println(drl);
		kieHelper.addContent(drl,ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		Student s2 = new Student();
		s2.setAge(20);
		s2.setName("test2");
		s2.setClassName("三班");
		kieSession.insert(s2);
		int count = kieSession.fireAllRules();
		System.out.println("总共执行了count："+count+"条规则");
		System.out.println(s2);
		kieSession.dispose();
	}

	/**
	 * 规则模板之hashmap初始化数据
	 */
	@Test
	public void ruleTemplate1Test() {
		Collection<Map<String,Object>> paramMaps = new ArrayList<Map<String,Object>>();
		Map<String, Object> map1 = new HashMap<>();
		map1.put("name","张三");
		map1.put("age", 20);
		map1.put("className", "二班");
		paramMaps.add(map1);
		Map<String, Object> map2 = new HashMap<>();
		map2.put("name","李四");
		map2.put("age", 23);
		map2.put("className", "三班");
		paramMaps.add(map2);
		ObjectDataCompiler objectDataCompiler = new ObjectDataCompiler();
		String content = objectDataCompiler.compile(paramMaps, Thread.currentThread().getContextClassLoader().getResourceAsStream("rules/template/template1.drl"));
		System.out.println(content);

		kieHelper.addContent(content,ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		Student s2 = new Student();
		s2.setAge(20);
		s2.setName("test2");
		s2.setClassName("三班");
		kieSession.insert(s2);
		int count = kieSession.fireAllRules();
		System.out.println("总共执行了count："+count+"条规则");
		kieSession.dispose();
	}

	/**
	 * 规则模板之java对象初始化模板数据
	 */
	@Test
	public void ruleTemplate2Test() {
		Student s = new Student();
		s.setAge(30);
		s.setName("test");
		s.setClassName("二班");

		Student s1 = new Student();
		s1.setAge(20);
		s1.setName("test1");
		s1.setClassName("二班");

		Collection<Student> data = new ArrayList<Student>();
		data.add(s1);
		data.add(s);
		ObjectDataCompiler objectDataCompiler = new ObjectDataCompiler();
		String content = objectDataCompiler.compile(data, Thread.currentThread().getContextClassLoader().getResourceAsStream("rules/template/template1.drl"));
		System.out.println(content);

		kieHelper.addContent(content,ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		Student s2 = new Student();
		s2.setAge(20);
		s2.setName("test2");
		s2.setClassName("三班");
		kieSession.insert(s2);
		int count = kieSession.fireAllRules();
		System.out.println("总共执行了count："+count+"条规则");
		kieSession.dispose();
	}

	/**
	 * 规则流测试
	 * https://www.iteye.com/blog/mywaylife-2026325
	 */
	@Test
	public void ruleFlowTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/activity/AwardPunish.drl"), ResourceType.DRL);
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/activity/BonusRule.drl"), ResourceType.DRL);
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/activity/EduInfoRule.drl"), ResourceType.DRL);
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/activity/Resume.drl"), ResourceType.DRL);
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/activity/TotalRule.drl"), ResourceType.DRL);
		//bpmn和rf都支持
//		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/activity/salary.bpmn"), ResourceType.BPMN2);
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/activity/salary.rf"), ResourceType.DRF);
		KieSession kieSession = kieHelper.build().newKieSession();
		Employ emp = new Employ();
		emp.setEduInfo("master");
		emp.setResume("tech");
		emp.setAnnualExam("good");
		emp.setAwardPunish("award");
		kieSession.insert(emp);
		kieSession.startProcess("salary");
		kieSession.fireAllRules();
		System.out.println("rate       : " + emp.getPercent());
		System.out.println("Bonus      : " + emp.getBonus());
		System.out.println("Basic Salary: " + emp.getBasicSalary());
		System.out.println("Duty Salary: " + emp.getDutySalary());
		System.out.printf("Total Salary: %.0f" , emp.getTotalSalary());
		System.out.println(emp);
	}


	/**
	 * 集成案例
	 */
	@Test
	public void promationDemoTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/promation.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		Order order1 = new Order();
		OrderItem orderItem1 = new OrderItem(1, 1101, 299d, 299d, "1101", "2201", 1);
//		OrderItem orderItem2 = new OrderItem(2, 1101, 399d, 399d, "1102", "2202", 1);
		//OrderItem orderItem3 = new OrderItem(3, 1101, 399d, 399d, "1103", "2203", 1);
		//OrderItem orderItem4 = new OrderItem(4, 1101, 399d, 399d, "1104", "2204", 1);
		order1.getItemList().add(orderItem1);
//		order1.getItemList().add(orderItem2);
		//order1.getItemList().add(orderItem3);
		//order1.getItemList().add(orderItem4);
		KieSession kSession = kieHelper.build().newKieSession();
		for (OrderItem item : order1.getItemList()) {
			kSession.insert(item);
		}
		kSession.insert(order1);
		int count = kSession.fireAllRules();
		System.out.println("总共触发了: " + count + " 条规则");
		Gson gson = new Gson();
		System.out.println(gson.toJson(order1));
//		BigDecimal bigDecimal = new BigDecimal(1);
//		BigDecimal multiply = bigDecimal.subtract(new BigDecimal(2));
//		System.out.println(multiply);

	}

	/**
	 * 决策表demo举例说明
	 */
	@Test
	@Deprecated
	public void demoTest() {
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/rule/demo/demo1.drl"), ResourceType.DRL);
		KieSession kieSession = kieHelper.build().newKieSession();
		Input input = new Input();
		InputItem item1 = new InputItem("0000");
		InputItem item2 = new InputItem("1111");
		InputItem item3 = new InputItem("2222");
		input.getInputList().add(item1);
		input.getInputList().add(item2);
		input.getInputList().add(item3);
		KieSession kSession = kieHelper.build().newKieSession();
		List<OutputItem> outputItems = new ArrayList<OutputItem>();
		for (InputItem item : input.getInputList()) {
			OutputItem outputItem = new OutputItem();
			outputItem.setCode(item.getCode());
			outputItems.add(outputItem);
		}
		kSession.insert(input);
		Output output = new Output();
		output.setOutputItems(outputItems);
		kSession.insert(output);
		int count = kSession.fireAllRules();
		System.out.println("总共触发了: " + count + " 条规则");
		Gson gson = new Gson();
		System.out.println(gson.toJson(output));
	}
}

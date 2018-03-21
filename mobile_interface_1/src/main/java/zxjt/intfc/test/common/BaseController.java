package zxjt.intfc.test.common;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

//@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
@ContextConfiguration({ "classpath:spring/spring-mongo.xml" })
public class BaseController extends AbstractTestNGSpringContextTests{

}

package cn.jiayuli.junit;

import org.junit.*;

public class testJunit {
    public testJunit() {
        System.out.println("testJunit的构造函数");
    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("@BeforeClass");
    }
    @Before
    public void before() {
        System.out.println("@Before");
    }
    @Test
    public void test() {
        System.out.println("@Test");
    }
    @Test
    public void testAdd() {
        System.out.println("testAdd():1+2=3");
        Assert.assertEquals(1+2, 3);
    }
    @Test
    public void testSubtract() {
        System.out.println("testSubtract():3-1=2");
        Assert.assertEquals(3-1, 2);
    }
    @Test
    public void testMultiply() {
        System.out.println("testMultiple():2*2=4");
        Assert.assertEquals(2*2, 4);
    }
    @Test
    public void testDivide() {
        System.out.println("testDivide():4/2=2");
        Assert.assertEquals(4/2, 2);
    }
    @Ignore
    public void ignore() {
        System.out.println("@Ignore");
    }
    @After
    public void after() {
        System.out.println("@After");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("@AfterClass");
    }
}

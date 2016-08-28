package org.jufe.erp.controller.test;

import org.bson.types.ObjectId;
import org.jufe.erp.entity.test.MongoTest;
import org.jufe.erp.repository.test.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by raomengnan on 16-8-25.
 */
@RestController
public class TestController {


    @Autowired
    private TestRepository testRepository;

    @RequestMapping("/test")
    public String test(){
        String str = "Test123";
        return str;

    }

    @RequestMapping("/testAdds")
    public String testAdd(){
        for (int i = 0; i < 100; ++i){
            MongoTest test = new MongoTest();
            test.setId("testid" + i);
            test.setName("test"+i);
            test.setTestDouble(Math.random());
            test.setRegistDate(new Date());
            testRepository.addTest(test);
        }

        return "finish";
    }

    @RequestMapping("/testFind")
    public MongoTest testFind(){
        MongoTest  test = testRepository.getTestById("testid10");
        System.out.println(test.getId());
        System.out.println(test.getTestList());
//        test.setName("hhhhhhhhhhhhhhhhhhhhhhhhhh");
//        testRepository.update(test);
        return test;

//        MongoTest t = new MongoTest();
//        t.setName("12345678980");
//        testRepository.update(t);
//        return t;
    }

    @RequestMapping("/testCount")
    public long testCount(){
        return testRepository.testCount();
    }

    public static void main(String[] args) {
        System.out.println(new ObjectId("57c2b04b0ab75d2b98344ae3").getDate());
    }


}

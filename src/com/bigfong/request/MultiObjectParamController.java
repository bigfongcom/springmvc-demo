package com.bigfong.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bigfong.vo.Cat;
import com.bigfong.vo.Dog;

/***********************************************************************   
* 处理多个对象的封装
* @author        bigfong
* @create-time   2018年11月8日 上午11:37:33
* @revision      $Id: 1.0  
*   
***********************************************************************/

@Controller
@RequestMapping("/multiobjectparam")
public class MultiObjectParamController {
    
    /*
          需要把表单数据封装到多个对象去的时候，如果各个对象都有相同的属性，此时要出问题
           不知道该把哪一个参数封装到哪一个对象中去
     */
    //从参数-->对象，封装规则需要我们来设置
    
    @InitBinder("dog") //自定义数据绑定注册，用于将请求数据转换到对应的对象的属性中去
    public void initBinderDogType(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("dog.");
    }
    @InitBinder("cat") //自定义数据绑定注册，用于将请求数据转换到对应的对象的属性中去
    public void initBinderCatType(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("cat.");
    }
    
    @RequestMapping("/save")
    public ModelAndView save(Cat cat,Dog dog) {
        System.out.println(cat);
        System.out.println(dog);
        return null;
    }
}

package com.bigfong.date;

import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;

/***********************************************************************   
*
* @author        bigfong
* @create-time   2018年11月8日 下午3:16:21
* @revision      $Id: 1.0  
*   
***********************************************************************/

@ControllerAdvice
public class DateFormatAdvice {
  //如果不想每次都在Date类开上添加@DateTimeFormat,则要把vo实体类中@DateTimeFormat这个去掉
    public void initBinderDateType(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd");
        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true));
    }
}

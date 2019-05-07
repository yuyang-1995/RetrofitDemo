package com.example.retrofitdemo;

/**
 * yuyang
 * 2019/5/7
 * 18:06
 */

/**
 * 返回数据
 * {
 * 	"status": 1,
 * 	"content": {
 * 		"from": "en-EU",
 * 		"to": "zh-CN",
 * 		"out": "\u793a\u4f8b",
 * 		"vendor": "ciba",
 * 		"err_no": 0
 *        }
 * }
 */
public class Translation {


  private int status;

    private Content content;

  private static class Content {
      private String from;
      private String to;
      private String vendor;
      private String out;
      private int errNo;
  }

  //定义输出返回数据的方法
    public void  show(){
        System.out.println(status);

        System.out.println(content.from);
        System.out.println(content.to);
        System.out.println(content.vendor);
        System.out.println(content.out);
        System.out.println(content.errNo);

    }

}

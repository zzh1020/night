package com.example.book.data;

public class ShopDatasource {
    public static int getShubi(int i){
        int count=50;
        count+=i;
        return count;
    }
    public static String getbookprice(int id){
        String content="";
        switch (id) {
            case 1:
                content="你当前购买的书籍为：\n斗罗大陆\n售价：39书币";
                break;
            case 2:
                content="你当前购买的书籍为：\n斗破苍穹\n售价：49书币";
                break;
            case 3:
                content="你当前购买的书籍为：\n龙族\n售价：79书币";
                break;
            case 4:
                content="你当前购买的书籍为：\n春水\n售价：69书币";
                break;
            case 5:
                content="你当前购买的书籍为：\n三体\n售价：19书币";
                break;
            case 6:
                content="你当前购买的书籍为：\n悲伤逆流成河\n售价：29书币";
                break;

        }
        return content;
    }
}

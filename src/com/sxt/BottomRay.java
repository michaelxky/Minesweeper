package com.sxt;

/**
 * 初始化地雷
 */
public class BottomRay {

    //存放坐标
    static int[] rays = new int[GameUtil.RAY_MAX*2];
    //地雷坐标
    int x,y;
    //是否放置 T 表示可以放置 F 不可放置
    boolean isPlace = true;

    //生成雷
    void newRay() {
        for (int i = 0; i < GameUtil.RAY_MAX*2 ; i=i+2) {
            x= (int) (Math.random()*GameUtil.MAP_W +1);//1-12
            y= (int) (Math.random()*GameUtil.MAP_H +1);//1-12
            //判断坐标是否存在
            for (int j = 0; j < i ; j=j+2) {
                if(x==rays[j] && y==rays[j+1]){
                    i=i-2;
                    isPlace = false;
                    break;
                }
            }
            //将坐标放入数组
            if(isPlace){
                rays[i]=x;
                rays[i+1]=y;
            }
            isPlace = true;
        }

        for (int i = 0; i < GameUtil.RAY_MAX*2; i=i+2) {
            GameUtil.DATA_BOTTOM[rays[i]][rays[i+1]]=-1;
        }
    }
}

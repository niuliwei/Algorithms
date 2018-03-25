package com.qiyei.sort;

/**
 * @author Created by qiyei2015 on 2018/3/19.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 归并排序
 */
public class MergeSort extends BaseSort{

    private Comparable[] aux;

    @Override
    public void sort(Comparable[] array) {
        aux = new Comparable[array.length];

        int lo = 0;
        int hi = array.length - 1;
        sort(array,lo,hi);
    }

    /**
     * 归并排序
     * @param array
     * @param lo
     * @param hi
     */
    private void sort(Comparable[]array,int lo,int hi){
        if (hi <= lo){
            return;
        }
        int mid = lo + (hi - lo)/2;
        //排左半边
        sort(array,lo,mid);
        //排右半边
        sort(array,mid + 1,hi);
        //归并
        merge(array,lo,mid,hi);
    }

    /**
     * 数组合并
     * @param array
     * @param lo
     * @param mid
     * @param hi
     */
    private void merge(Comparable[] array,int lo,int mid,int hi){
        int i = lo;
        int j = mid + 1;

        //将数组array复制到aux中
        for (int k = lo ;k < hi ; k++){
            aux[k] = array[k];
        }

        for (int k = lo ; k < hi ; k++){

            if (i > mid){
                //i 超过mid，说明左半边用完，取右半边
                array[k] = aux[j++];
            }else if (j > hi){
                //j 超过hi，说明右半边用完，取左半边
                array[k] = array[i++];

            }else if (less(array[i],array[j])){
                //i 比j小，取i
                array[k] = array[i++];
            }else {
                array[k] = array[j++];
            }
        }
    }

}
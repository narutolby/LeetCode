package com.lby.main;

/**
 * Created with IntelliJ IDEA.
 * User: narutolby
 * Date: 13-10-6
 * Time: 下午4:50
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * Note:
 * The solution is guaranteed to be unique.
 */
public class Gas_Station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length,ret=-1,gasSum=0,costSum=0;
        if(len==0){
            return -1;
        }
        for(int i=0;i<len;i++){
           if(gas[i]<cost[i]){
               continue;
           }
           gasSum=0;
           costSum = 0;
           int j = 0;
           for(j=i;j<i+len;j++){
               gasSum+=gas[j%len];
               costSum+=cost[j%len];
               if(gasSum<costSum){
                   break;
               }
           }
            if(j==i+len){
                ret = i;
                break;
            }
        }
        return ret;
    }
}

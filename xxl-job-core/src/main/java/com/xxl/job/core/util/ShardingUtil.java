package com.xxl.job.core.util;

/**
 * sharding vo
 * @author xuxueli 2017-07-25 21:26:38
 */
public class ShardingUtil {

    private static InheritableThreadLocal<ShardingVO> contextHolder = new InheritableThreadLocal<ShardingVO>();

    public static class ShardingVO {

        /**
         * sharding index
         *
         * current sharding serial number (starting from 0)
         * the serial number of the current executor in the list of executor clusters
         */
        private int index;
        /**
         *  sharding total
         *
         *  the total number of shards, the total number of machines in the executor clusters
         */
        private int total;  // sharding total

        public ShardingVO(int index, int total) {
            this.index = index;
            this.total = total;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }

    public static void setShardingVo(ShardingVO shardingVo){
        contextHolder.set(shardingVo);
    }

    public static ShardingVO getShardingVo(){
        return contextHolder.get();
    }

}

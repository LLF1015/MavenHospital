package com.qst.bean;

public class Pages {
        private int pageRecord;// 每页面的记录数

        private int totalRecord;// 总记录数
        private int currentPage = 1;// 当前页

        private int pageNumStart;// 页码显示开始;
        private int pageNumEnd;// 页码显示结束;
        private int totalPage;// 总页数;


        private int showPageCount=10;// 显示页码个数，默认是10
        public Pages() {

        }

        public Pages(int currentPage, int totalRecord,int pageRecord) {
            this.totalRecord = totalRecord;
            this.currentPage = currentPage;
            this.pageRecord = pageRecord;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getPageRecord() {
            return pageRecord;
        }

        public int getTotalRecord() {
            return totalRecord;
        }

        public void setTotalRecord(int totalRecord) {
            this.totalRecord = totalRecord;
        }

        /**
         * 获取总页数
         *
         * @return
         */
        public int getTotalPage() {
            this.totalPage=this.totalRecord % this.pageRecord == 0 ? this.totalRecord / this.pageRecord
                    : this.totalRecord / this.pageRecord + 1;
            return this.totalPage;
        }

        /**
         * 获取当前页
         *
         * @return
         */
        public int getCurrentPage() {

            if (currentPage > getTotalPage()) {

                this.currentPage = getTotalPage();
            }
            if (currentPage < 1) {
                this.currentPage = 1;
            }

            return currentPage;
        }

        /**
         * next page
         *
         * @return
         */
        public int getNextPage() {
            return this.getCurrentPage() + 1;
        }

        /**
         * previous page
         *
         * @return
         */
        public int getPrePage() {
            return this.getCurrentPage() - 1;
        }

        /**
         * 页码显示起始数字
         *
         * @return
         */
        public int getPageNumStart() {
            // 显示页数的一半
            int halfPage = (int) Math.ceil((double) showPageCount / 2);
            if (halfPage >= currentPage) {
                this.pageNumStart = 1;
            } else {
                if (currentPage + halfPage > getTotalPage()) {
                    this.pageNumStart = (getTotalPage() - showPageCount + 1) <= 0 ? 1
                            : (getTotalPage() - showPageCount + 1);
                } else {
                    this.pageNumStart = currentPage - halfPage + 1;
                }
            }
            return pageNumStart;
        }

        /**
         * 页码显示结束数字
         *
         * @return
         */
        public int getPageNumEnd() {
            // 显示页数的一半
            int halfPage = (int) Math.ceil((double) showPageCount / 2);
            if (halfPage >= currentPage) {
                this.pageNumEnd = showPageCount > getTotalPage() ? getTotalPage() : showPageCount;
            } else {
                if (currentPage + halfPage >= getTotalPage()) {

                    this.pageNumEnd = getTotalPage();
                } else {

                    this.pageNumEnd = currentPage + halfPage;
                }
            }
            return pageNumEnd;
        }
}

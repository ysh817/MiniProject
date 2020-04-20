package com.enuri.myweb.vo.page;

public class PageMaker {
	

		private int min;
		private int max;
		private int prevPage;
		private int nextPage;
		private int pageCnt; //전체
		private int currentPage;
		
		
		// contentCnt : 전체글 개수 
		//currentPage : 현재 글 번호 
		//contentPageCnt : 페이지당 글의 개수
		//paginRange : 페이지 버튼의 개수
		public PageMaker(int contentCnt, int currentPage, int contentPageCnt, int paginRange) {

			this.currentPage = currentPage;
			
			pageCnt = contentCnt / contentPageCnt;
			if(contentCnt % contentPageCnt > 0) { //소수자릿수있으면 +1
				pageCnt++;
			}
			
			min = ((currentPage - 1) / paginRange) * paginRange + 1; //1,6,11,16...
			max = min + paginRange - 1;
			
			if(max > pageCnt) {
				max = pageCnt;
			}
			
			prevPage = min - 1;
			nextPage = max + 1;
			if(nextPage > pageCnt) {
				nextPage = pageCnt;
			}
		}


		public int getMin() {
			return min;
		}


		public void setMin(int min) {
			this.min = min;
		}


		public int getMax() {
			return max;
		}


		public void setMax(int max) {
			this.max = max;
		}


		public int getPrevPage() {
			return prevPage;
		}


		public void setPrevPage(int prevPage) {
			this.prevPage = prevPage;
		}


		public int getNextPage() {
			return nextPage;
		}


		public void setNextPage(int nextPage) {
			this.nextPage = nextPage;
		}


		public int getPageCnt() {
			return pageCnt;
		}


		public void setPageCnt(int pageCnt) {
			this.pageCnt = pageCnt;
		}


		public int getCurrentPage() {
			return currentPage;
		}


		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}
		
		
		

}

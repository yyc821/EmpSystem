package entity;



public class PageResult {
	   
    private int count;
    public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	//褰撳墠椤垫暟
    private int pageNo;
    //姣忛〉鏄剧ず鐨勬潯鏁�
    private int pageSize;
    //鎬婚〉鏁�
    private int pageCount;
    //鍐呭
    

}

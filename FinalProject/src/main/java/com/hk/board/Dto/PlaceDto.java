package com.hk.board.Dto;

public class PlaceDto {
	
	   private String resultCode;
	    private String resultMag;
	    private String items;

	    private String rnum;
	    private String cnt;

	    private String distance;

	    private String dutyAddr;

	    private String dutyDiv;

	    private String dutyDivName;

	    private String dutyFax;

	    private String dutyName;

	    private String dutyTel1;

	    private String endTime;

	    private String hpid;

	    private String latitude;

	    private String longitude;

	    private String startTime;

		public String getResultCode() {
			return resultCode;
		}

		public void setResultCode(String resultCode) {
			this.resultCode = resultCode;
		}

		public String getResultMag() {
			return resultMag;
		}

		public void setResultMag(String resultMag) {
			this.resultMag = resultMag;
		}

		public String getItems() {
			return items;
		}

		public void setItems(String items) {
			this.items = items;
		}

		public String getRnum() {
			return rnum;
		}

		public void setRnum(String rnum) {
			this.rnum = rnum;
		}

		public String getCnt() {
			return cnt;
		}

		public void setCnt(String cnt) {
			this.cnt = cnt;
		}

		public String getDistance() {
			return distance;
		}

		public void setDistance(String distance) {
			this.distance = distance;
		}

		public String getDutyAddr() {
			return dutyAddr;
		}

		public void setDutyAddr(String dutyAddr) {
			this.dutyAddr = dutyAddr;
		}

		public String getDutyDiv() {
			return dutyDiv;
		}

		public void setDutyDiv(String dutyDiv) {
			this.dutyDiv = dutyDiv;
		}

		public String getDutyDivName() {
			return dutyDivName;
		}

		public void setDutyDivName(String dutyDivName) {
			this.dutyDivName = dutyDivName;
		}

		public String getDutyFax() {
			return dutyFax;
		}

		public void setDutyFax(String dutyFax) {
			this.dutyFax = dutyFax;
		}

		public String getDutyName() {
			return dutyName;
		}

		public void setDutyName(String dutyName) {
			this.dutyName = dutyName;
		}

		public String getDutyTel1() {
			return dutyTel1;
		}

		public void setDutyTel1(String dutyTel1) {
			this.dutyTel1 = dutyTel1;
		}

		public String getEndTime() {
			return endTime;
		}

		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}

		public String getHpid() {
			return hpid;
		}

		public void setHpid(String hpid) {
			this.hpid = hpid;
		}

		public String getLatitude() {
			return latitude;
		}

		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}

		public String getLongitude() {
			return longitude;
		}

		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}

		public String getStartTime() {
			return startTime;
		}

		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}

		@Override
		public String toString() {
			return "PlaceDto [resultCode=" + resultCode + ", resultMag=" + resultMag + ", items=" + items + ", rnum="
					+ rnum + ", cnt=" + cnt + ", distance=" + distance + ", dutyAddr=" + dutyAddr + ", dutyDiv="
					+ dutyDiv + ", dutyDivName=" + dutyDivName + ", dutyFax=" + dutyFax + ", dutyName=" + dutyName
					+ ", dutyTel1=" + dutyTel1 + ", endTime=" + endTime + ", hpid=" + hpid + ", latitude=" + latitude
					+ ", longitude=" + longitude + ", startTime=" + startTime + "]";
		}

}

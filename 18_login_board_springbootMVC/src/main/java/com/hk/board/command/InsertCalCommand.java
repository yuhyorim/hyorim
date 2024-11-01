package com.hk.board.command;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// client: 파라미터 ----> command객체가 받음
// controller -- service --> DTO --> DB
// 클라이언트에서 전달되는 파라미터와 DTO에 선언된 맴버필드가 일치하지 않음
// 클라이언트에서 입력되는 값에 대해 유효값처리를 설정
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class InsertCalCommand {

	private int seq;
	@NotBlank(message = "아이디를 입력하세요") //문자열만 가능
	private String id;
	@NotBlank(message = "제목을 입력하세요") //문자열만 가능
	private String title;
	@NotBlank(message = "일정내용을 입력하세요") //문자열만 가능
	private String content;
	
	@NotNull(message = "시작 날짜를 입력하세요") private LocalDate startDate; // 시작 날짜 필드 추가 
	@NotNull(message = "종료 날짜를 입력하세요") private LocalDate endDate; // 종료 날짜 필드 추가
	
	private int hour;
	@NotNull(message = "분을 입력하세요")
	private int min;
	private String groupId;
	
	

	public InsertCalCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsertCalCommand(int seq, @NotBlank(message = "아이디를 입력하세요") String id,
			@NotBlank(message = "제목을 입력하세요") String title, @NotBlank(message = "일정내용을 입력하세요") String content,
			@NotNull(message = "시작 날짜를 입력하세요")LocalDate startDate, @NotNull(message = "종료 날짜를 입력하세요")LocalDate endDate, @NotNull(message = "시간을 입력하세요") int hour,
			@NotNull(message = "분을 입력하세요") int min) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.startDate= startDate;
		this.endDate= endDate;
		this.hour = hour;
		this.min = min;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}
	
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	@Override
	public String toString() {
		return "InsertCalCommand [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", hour=" + hour + ", min=" + min + ", groupId="
				+ groupId + "]";
	}

	
	
	
	
}





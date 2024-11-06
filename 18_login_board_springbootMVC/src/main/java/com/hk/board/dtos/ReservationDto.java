package com.hk.board.dtos;

import java.time.LocalDateTime;

public class ReservationDto {
    private Long id;
    private Long boardId;
    private Long userId;
    private LocalDateTime reservedAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getBoardId() {
		return boardId;
	}
	public void setBoardId(Long boardId) {
		this.boardId = boardId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public LocalDateTime getReservedAt() {
		return reservedAt;
	}
	public void setReservedAt(LocalDateTime reservedAt) {
		this.reservedAt = reservedAt;
	}
	@Override
	public String toString() {
		return "ReservationDto [id=" + id + ", boardId=" + boardId + ", userId=" + userId + ", reservedAt=" + reservedAt
				+ "]";
	}

    // Getter, Setter
    
    
}

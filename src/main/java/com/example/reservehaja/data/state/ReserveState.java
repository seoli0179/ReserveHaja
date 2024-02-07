package com.example.reservehaja.data.state;

public enum ReserveState {
    RESERVE_JUDGE("심사중"),
    RESERVE_COMPLETE("예약완료"),
    RESERVE_CANCEL("예약취소");

    private final String label;

    // enum 생성자
    ReserveState(String label) {
        this.label = label;
    }

    // description 값을 반환하는 getter 메서드
    public String getLabel() {
        return label;
    }

}

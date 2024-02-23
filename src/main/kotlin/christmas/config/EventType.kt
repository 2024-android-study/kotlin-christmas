package christmas.config

enum class EventType(val type: String, val value: Int) {
    EVENT_CHRISTMAS_DDAY("크리스마스 디데이 할인", 100),
    EVENT_WEEKDAY("평일 할인", 2023),
    EVENT_WEEKEND("주말 할인", 2023),
    EVENT_SPECIAL("특별 할인", 1000),
    EVENT_PRESENT("증정 이벤트", 120000);
}
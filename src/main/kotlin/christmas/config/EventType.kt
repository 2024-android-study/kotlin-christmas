package christmas.config

enum class EventType(val type: String, val value: Int) {
    Event_CHRISTMAS_DDAY("크리스마스 디데이 할인", 100),
    Event_WEEKDAY("평알 할인", 2023),
    Event_WEEKEND("주말 할인", 2023),
    Event_SPECIAL("특별 할인", 1000),
    PRESENT_EVENT("증정 이벤트", 120000)
}
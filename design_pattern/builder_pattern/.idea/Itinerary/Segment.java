public final class Segment{

    private final String from;
    private final String to;
    private final LocalDateTime departureTime;
    private final LocalDateTime arrivalTime;
    private final String carrier;

    public Segment(String from, String to, LocalDateTime departureTime, LocalDateTime arrivalTime, String carrier){
        if(!isValidIata(from)){
            throw new IllegalArgumentException("from must be a 3-letter IATA code: " + from : " ");
        }

        if(!isValidIata(to)){
            throw new IllegalArgumentException("to must be a 3-letter IATA code: " + to + " ");
        }

        if(departureTime == null || arrivalTime == null){
            throw new IllegalArgumentException("departureTime and arrivalTime must not be null");
        }

        if(arrivalTime.isBefore(departureTime)){
            throw new IllegalArgumentException("departureTime must not be before arrival time");
        }

        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.carrier = carrier;
    }

    private boolean isValidIata(String code){
        return code != null && code.matches("[A-Z]{3}");
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public String getCarrier() {
        return carrier;
    }
}
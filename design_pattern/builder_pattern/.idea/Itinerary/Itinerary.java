public final class Itinerary{

    private final String travelerName;
    private final String origin;
    private final String destination;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final List<Segment> segments;
    private final Set<String> tags;
    private final Money budget;
    private final boolean travelInsurance;

    private Itinerary(Builder builder){
        this.travelerName = builder.travelerName;
        this.origin = builder.origin;
        this.destination = builder.destination;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.segments = List.copyOff(builder.segments);
        this.tags = Set.copyOf(builder.tags);
        this.budget = builder.budget;
        this.travelInsurance = builder.travelInsurance;
    }

    public static Builder builder(){
        return new Builder();
    }

    public String getTravelerName() {
        return travelerName;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public Set<String> getTags() {
        return tags;
    }

    public Money getBudget() {
        return budget;
    }

    public boolean isTravelInsurance() {
        return travelInsurance;
    }

    @Override
    public java.lang.String toString() {
        return "Itinerary{" +
                "travelerName='" + travelerName + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", segments=" + segments +
                ", tags=" + tags +
                ", budget=" + budget +
                ", travelInsurance=" + travelInsurance +
                '}';
    }
}
import java.time.LocalDate;
import java.util.*;

public static class Builder {

    private String travelerName;
    private String origin;
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Segment> segments = new ArrayList<>();
    private Set<String> tags = new HashSet<>();
    private Money budget;
    private boolean travelInsurance;

    public Builder travelerName(String travelerName) {
        this.travelerName = travelerName;
        return this;
    }

    public Builder origin(String origin) {
        this.origin = origin;
        return this;
    }

    public Builder destination(String destination) {
        this.destination = destination;
        return this;
    }

    public Builder startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public Builder endDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public Builder travelInsurance(boolean travelInsurance) {
        this.travelInsurance = travelInsurance;
        return this;
    }

    public Builder segments(List<Segment> segments) {
        this.segments = new ArrayList<>(segments); // defensive copy
        return this;
    }

    public Builder tags(Set<String> tags) {
        this.tags = new HashSet<>(tags); // defensive copy
        return this;
    }

    public Builder budget(Money budget) {
        this.budget = budget;
        return this;
    }

    public Builder addSegment(Segment segment) {
        this.segments.add(segment);
        return this;
    }

    public Builder addTag(String tag) {
        this.tags.add(tag);
        return this;
    }

    public Itinerary build() {
        validate();
        return new Itinerary(this);
    }

    private void validate() {

        if (travelerName == null || travelerName.isBlank()) {
            throw new IllegalStateException("travelerName must be non-empty");
        }

        if (origin == null || origin.isBlank()) {
            throw new IllegalStateException("origin is required");
        }

        if (destination == null || destination.isBlank()) {
            throw new IllegalStateException("destination is required");
        }

        if (startDate == null) {
            throw new IllegalStateException("startDate is required");
        }

        if (endDate == null) {
            throw new IllegalStateException("endDate is required");
        }

        if (endDate.isBefore(startDate)) {
            throw new IllegalStateException("endDate is before startDate");
        }

        if (!origin.matches("[A-Z]{3}")) {
            throw new IllegalStateException("origin must be 3-letter IATA: '" + origin + "'");
        }

        if (!destination.matches("[A-Z]{3}")) {
            throw new IllegalStateException("destination must be 3-letter IATA: '" + destination + "'");
        }

        if (!segments.isEmpty()) {
            validateSegments();
        }
    }

    private void validateSegments() {

        for (int i = 1; i < segments.size(); i++) {
            Segment prev = segments.get(i - 1);
            Segment curr = segments.get(i);

            if (curr.getDepartAt().isBefore(prev.getDepartAt())) {
                throw new IllegalStateException(
                        "Segments not in chronological order at index " + i
                );
            }

            if (!prev.getTo().equals(curr.getFrom())) {
                throw new IllegalStateException(
                        "Segments must be contiguous: '" +
                                prev.getTo() + "' followed by '" +
                                curr.getFrom() + "'"
                );
            }
        }

        Segment first = segments.get(0);
        Segment last = segments.get(segments.size() - 1);

        if (!first.getFrom().equals(origin)) {
            throw new IllegalStateException(
                    "First segment must start from origin: expected " +
                            origin + " but found " + first.getFrom()
            );
        }

        if (!last.getTo().equals(destination)) {
            throw new IllegalStateException(
                    "Last segment must end at destination: expected " +
                            destination + " but found " + last.getTo()
            );
        }
    }
}
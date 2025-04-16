package mk.finki.ukim.mk.lab_b.model.exceptions;

public class AccommodationAlreadyInBookingException extends RuntimeException {
  public AccommodationAlreadyInBookingException(Long id, String username) {
    super(String.format("Accommodation with id: %d already exists in booking for user with username %s", id, username));
  }
}

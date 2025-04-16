package mk.finki.ukim.mk.lab_b.model.exceptions;

public class AccommodationNotFoundException extends RuntimeException {
  public AccommodationNotFoundException(Long id) {
    super(String.format("Accommodation with id: %d was not found", id));
  }
}

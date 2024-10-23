package JavaInterview1;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Movie {
	public Movie(String name, int durationMinutes) {
		super();
		this.name = name;
		this.durationMinutes = durationMinutes;
	}

	String name;
	int durationMinutes;
}

class Screen {
	public Screen(int screenNumber, List<TimeSlot> availableSlots) {
		super();
		this.screenNumber = screenNumber;
		this.availableSlots = availableSlots;
	}

	int screenNumber;
	List<TimeSlot> availableSlots; // Initially one slot: 09:00-23:00
}

class TimeSlot {
	public TimeSlot(LocalTime startTime, LocalTime endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}

	LocalTime startTime;
	LocalTime endTime;

}

class ShowSchedule {

	public ShowSchedule(int screenNumber, String movieName, LocalTime startTime, LocalTime endTime) {
		super();
		this.screenNumber = screenNumber;
		this.movieName = movieName;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	int screenNumber;
	String movieName;
	LocalTime startTime;
	LocalTime endTime;

	@Override
	public String toString() {
		return "ShowSchedule [screenNumber=" + screenNumber + ", movieName=" + movieName + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
}

public class MovieShowTimeScheduler {
	public static List<ShowSchedule> scheduleMovies(List<Movie> movies, List<Screen> screens) {

		List<ShowSchedule> schedule = new ArrayList<>();

		movies.sort((m1, m2) -> Integer.compare(m2.durationMinutes, m1.durationMinutes));

		for (Screen screen : screens) {
			screen.availableSlots.sort((a1, a2) -> a1.startTime.compareTo(a2.startTime));

			for (TimeSlot slot : screen.availableSlots) {
				scheduleMovie(movies, screen, slot, schedule);
			}
		}

		return schedule;

	}

	public static void scheduleMovie(List<Movie> movies, Screen screen, TimeSlot slot, List<ShowSchedule> schedule) {

		for (Movie movie : movies) {

			LocalTime startTime = slot.startTime;
			LocalTime endTime = startTime.plusMinutes(movie.durationMinutes);

			if (endTime.isBefore(slot.endTime) || endTime.equals(slot.endTime)) {
				schedule.add(new ShowSchedule(screen.screenNumber, movie.name, startTime, endTime));
			}

			TimeSlot newSlot = new TimeSlot(endTime.plusMinutes(30), slot.endTime);
			screen.availableSlots.add(newSlot);

			screen.availableSlots.remove(slot);

			scheduleMovie(movies, screen, newSlot, schedule);
			break;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Movie> movies =

				Arrays.asList(new Movie("Avatar", 180), new Movie("Spider-Man", 150), new Movie("Inception", 160));

		List<Screen> screens = Arrays.asList(
				new Screen(1, Arrays.asList(new TimeSlot(LocalTime.of(9, 0), LocalTime.of(23, 0)))),
				new Screen(2, Arrays.asList(new TimeSlot(LocalTime.of(9, 0), LocalTime.of(23, 0)))));

		List<ShowSchedule> schedule = scheduleMovies(movies, screens);

		for (ShowSchedule show : schedule) {
			System.out.println(show);
		}

	}

}

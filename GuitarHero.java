public class GuitarHero {
	public static void main(String[] args) {

		String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

		GuitarString guitar_string[] = new GuitarString[37];

		for (int i = 0; i < 37; ++i) {
			guitar_string[i] = new GuitarString(440.0 * Math.pow(1.05956, i - 24));
		}

		while (true) {

			// check if the user has typed a key; if so, process it

			// This if statement only checks one key
			// However when we type multiple keys at the same time,
			// multiple notes appear. The reason is that each key is
			// played for each iteration of the while loop.
			// So, for example, when you press 'a' and 'c' at the same time
			// 'a' will get played first. And during the next iteration of the while loop,
			// 'c' will be played. However, at this point, 'a' still makes a sound such that it sounds
			// like 'a' and 'c' are played at the same time even though they are not.
			if (StdDraw.hasNextKeyTyped()) {
				char key = StdDraw.nextKeyTyped();

				for (int i = 0; i < 37; ++i) {
					if (key == keyboard.charAt(i)) {
						guitar_string[i].pluck();
					}
				}
			}

			// compute the super-position of samples
			double sample = 0.0;

			for (int i = 0; i < 37; ++i) {
				sample += guitar_string[i].sample();
			}

			// play the sample on standard audio
			StdAudio.play(sample);

			// advance the simulation of each guitar string by one step
			for (int i = 0; i < 37; ++i) {
				guitar_string[i].tic();
			}
		}
	}
}

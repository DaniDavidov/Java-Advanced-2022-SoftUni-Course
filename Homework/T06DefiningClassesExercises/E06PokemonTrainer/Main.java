package T06DefiningClassesExercises.E06PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Trainer> trainerMap = new LinkedHashMap<>();

        String line;
        while (!"Tournament".equals(line = scanner.nextLine())) {
            String[] data = line.split("\\s+");
            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainerMap.putIfAbsent(trainerName, new Trainer(trainerName, new ArrayList<>()));
            trainerMap.get(trainerName).getPokemons().add(pokemon);
        }

        String command;
        while (!"End".equals(command = scanner.nextLine())) {
            for (Map.Entry<String, Trainer> entry : trainerMap.entrySet()) {
                String finalCommand = command;
                List<Pokemon> elementPokemons = entry.getValue().getPokemons().stream()
                        .filter(pokemon -> pokemon.getElement().equals(finalCommand))
                        .collect(Collectors.toList());

                if (elementPokemons.size() > 0) {
                    int currentAmountOfBadges = entry.getValue().getNumberOfBadges();
                    entry.getValue().setNumberOfBadges(currentAmountOfBadges + 1);
                } else {
                    List<Pokemon> pokemonsWithReducedHealth = entry.getValue().getPokemons().stream()
                            .peek(pokemon -> {
                                int currentPokemonHealth = pokemon.getHealth();
                                pokemon.setHealth(currentPokemonHealth - 10);
                            })
                            .filter(pokemon -> pokemon.getHealth() > 0)
                            .collect(Collectors.toList());
                    entry.getValue().setPokemons(pokemonsWithReducedHealth);
                }
            }

        }
        trainerMap.entrySet().stream()
                .sorted((trainer1, trainer2) -> Integer.compare(trainer2.getValue().getNumberOfBadges(),
                        trainer1.getValue().getNumberOfBadges()))
                .forEach(trainer -> System.out.printf("%s %d %d%n", trainer.getValue().getName(),
                        trainer.getValue().getNumberOfBadges(), trainer.getValue().getPokemons().size()));
    }
}

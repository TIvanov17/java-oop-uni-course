package abstraction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimalAbilitySaver {

    private final Map<String, Double> animalAbilityMapSaver;

    public AnimalAbilitySaver(){
        animalAbilityMapSaver = new HashMap<>();
    }

    public void saveAbility(Ability ability){
        animalAbilityMapSaver.put(ability.getName(), ability.getValue());
    }

    public void saveMultipleAbilities(List<Ability> abilityCollection){

        for(Ability currentAbility: abilityCollection){
            this.animalAbilityMapSaver.put(currentAbility.getName(), currentAbility.getValue());
        }
    }

    public Double restore(Ability ability){

        return this.restoreByName(ability.getName());
    }

    public Double restoreByName(String abilityName){

        if(animalAbilityMapSaver.containsKey(abilityName)){
            return animalAbilityMapSaver.get(abilityName);
        }

        throw new IllegalArgumentException();
    }
}

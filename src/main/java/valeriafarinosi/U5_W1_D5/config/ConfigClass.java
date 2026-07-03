package valeriafarinosi.U5_W1_D5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import valeriafarinosi.U5_W1_D5.entities.Building;
import valeriafarinosi.U5_W1_D5.entities.User;
import valeriafarinosi.U5_W1_D5.entities.Workstation;
import valeriafarinosi.U5_W1_D5.enums.WS_TYPE;

@Configuration
public class ConfigClass {

    //    BUILDINGS
    @Bean
    public Building BagEndHub() {
        return new Building("Bag End", "Bagshot Row", "Hobbiton");
    }

    @Bean
    public Building MinasTirithHeadQuarters() {
        return new Building("Minas Tirith Citadel", "Seventh Circle", "Minas Tirith");
    }

    @Bean
    public Building DurinMountainOffice() {
        return new Building("Durin's Hall", "Khazad-dum", "Moria");
    }

    //    WORKSTATIONS
    @Bean
    public Workstation Garden() {
        return new Workstation("GRDN", 2, WS_TYPE.PRIVATE, "Quiet desk with garden view", BagEndHub());
    }

    @Bean
    public Workstation Fireplace() {
        return new Workstation("FRPLC", 5, WS_TYPE.OPENSPACE, "Shared workspace near the fireplace.", BagEndHub());
    }

    @Bean
    public Workstation Tower() {
        return new Workstation("TWR", 1, WS_TYPE.PRIVATE, "Executive office with view of the White City.", MinasTirithHeadQuarters());
    }

    @Bean
    public Workstation Council() {
        return new Workstation("CNCL", 12, WS_TYPE.MEETING_ROOM, "Council chamber", MinasTirithHeadQuarters());
    }

    @Bean
    public Workstation GondorWorkers() {
        return new Workstation("GNDWK", 10, WS_TYPE.OPENSPACE, "Open workspace for Gondor Workers", MinasTirithHeadQuarters());
    }

    @Bean
    public Workstation EngeneeringWorkspace() {
        return new Workstation("ENGWS", 1, WS_TYPE.PRIVATE, null, DurinMountainOffice());
    }

    @Bean
    public Workstation MiningOpRoom() {
        return new Workstation("MNGOP", 8, WS_TYPE.MEETING_ROOM, "Mining operations meeting room", DurinMountainOffice());
    }

    //    USERS
    @Bean
    public User Frodo() {
        return new User("frodo.b", "Frodo", "Baggins", "frodo.baggins@mddleearth.com");
    }

    @Bean
    public User Sam() {
        return new User("samG", "Samwise", "Gamgee", "sam.gamgee@middleearth.com");
    }

    @Bean
    public User Gandalf() {
        return new User("gangre", "Gandalf", "Grey", "gandalf.grey@middleeath.com");
    }

    @Bean
    public User Legolas() {
        return new User("leggre", "Legolas", "Greenleaf", "legolas.greenleaf@middleearth.com");
    }

    @Bean
    public User Aragorn() {
        return new User("arag.ele", "Aragorn", "Elessar", "aragorn.elessar@middleearth.com");
    }

    @Bean
    public User Gimli() {
        return new User("gimli.s", "Gimli", "Son of Gloin", "gimli.gloin@middleearth.com");
    }


}

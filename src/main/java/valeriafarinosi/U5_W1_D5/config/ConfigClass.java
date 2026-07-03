package valeriafarinosi.U5_W1_D5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import valeriafarinosi.U5_W1_D5.entities.Building;
import valeriafarinosi.U5_W1_D5.entities.User;
import valeriafarinosi.U5_W1_D5.entities.Workstation;
import valeriafarinosi.U5_W1_D5.enums.WS_TYPE;

@Configuration
public class ConfigClass {

    //    USERS
    @Bean
    public User frodo() {
        return new User("frodo.b", "Frodo", "Baggins", "frodo.baggins@mddleearth.com");
    }

    @Bean
    public User sam() {
        return new User("samG", "Samwise", "Gamgee", "sam.gamgee@middleearth.com");
    }

    @Bean
    public User gandalf() {
        return new User("gangre", "Gandalf", "Grey", "gandalf.grey@middleeath.com");
    }

    @Bean
    public User legolas() {
        return new User("leggre", "Legolas", "Greenleaf", "legolas.greenleaf@middleearth.com");
    }

    @Bean
    public User aragorn() {
        return new User("arag.ele", "Aragorn", "Elessar", "aragorn.elessar@middleearth.com");
    }

    @Bean
    public User gimli() {
        return new User("gimli.s", "Gimli", "Son of Gloin", "gimli.gloin@middleearth.com");
    }

    //    BUILDINGS
    @Bean
    public Building bagEndHub() {
        return new Building("Bag End", "Bagshot Row", "Hobbiton");
    }

    @Bean
    public Building minasTirithHeadQuarters() {
        return new Building("Minas Tirith Citadel", "Seventh Circle", "Minas Tirith");
    }

    @Bean
    public Building durinMountainOffice() {
        return new Building("Durin's Hall", "Khazad-dum", "Moria");
    }

    //    WORKSTATIONS
    @Bean
    public Workstation garden() {
        return new Workstation("GRDN", 2, WS_TYPE.PRIVATE, "Quiet desk with garden view", bagEndHub());
    }

    @Bean
    public Workstation fireplace() {
        return new Workstation("FRPLC", 5, WS_TYPE.OPENSPACE, "Shared workspace near the fireplace.", bagEndHub());
    }

    @Bean
    public Workstation tower() {
        return new Workstation("TWR", 1, WS_TYPE.PRIVATE, "Executive office with view of the White City.", minasTirithHeadQuarters());
    }

    @Bean
    public Workstation council() {
        return new Workstation("CNCL", 12, WS_TYPE.MEETING_ROOM, "Council chamber", minasTirithHeadQuarters());
    }

    @Bean
    public Workstation gondorWorkers() {
        return new Workstation("GNDWK", 10, WS_TYPE.OPENSPACE, "Open workspace for Gondor Workers", minasTirithHeadQuarters());
    }

    @Bean
    public Workstation engeneeringWorkspace() {
        return new Workstation("ENGWS", 1, WS_TYPE.PRIVATE, null, durinMountainOffice());
    }

    @Bean
    public Workstation miningOpRoom() {
        return new Workstation("MNGOP", 8, WS_TYPE.MEETING_ROOM, "Mining operations meeting room", durinMountainOffice());
    }


}

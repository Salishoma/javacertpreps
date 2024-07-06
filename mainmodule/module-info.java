module mainmodule {
    requires java.sql;
    requires testmodule;
//    requires junit;
    uses src.module.service.AvailableService;
}
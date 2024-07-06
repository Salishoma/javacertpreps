module mainmodule {
    requires java.sql;
    requires testmodule;
//    requires org.junit;
    uses module.service.AvailableService;
}
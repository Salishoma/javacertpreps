module premium {
    requires testmodule;
    provides module.service.AvailableService with com.premium.service.PremiumService;
}
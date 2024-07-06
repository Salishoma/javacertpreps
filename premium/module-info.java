module premium {
    requires testmodule;
    provides src.module.service.AvailableService with src.com.premium.service.PremiumService;
}
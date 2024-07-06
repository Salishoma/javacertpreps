module community {
    requires testmodule;
    provides src.module.service.AvailableService with src.com.community.service.CommunityService;
}
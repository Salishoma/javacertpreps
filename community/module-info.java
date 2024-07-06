module community {
    requires testmodule;
    provides module.service.AvailableService with com.community.service.CommunityService;
}
var Battery = {
    getLevel: function (success, fail) {
        PhoneGap.exec(success, fail, "BatteryChecker", "getLevel", []);
    }
};

PhoneGap.addConstructor(function () {
    PhoneGap.addPlugin('battery', Battery);
    PluginManager.addService("BatteryChecker", "org.trevreport.BatteryChecker.BatteryChecker");
});

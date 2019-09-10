definition(
    name: "Speaker Companion (Custom)",
    namespace: "smartThingsAPP/parent",
    author: "fieldsjm",
    description: "Control your speaker, play a sound, a custom message when an event occurs or the system mode changes.",
    category: "My Apps",
    iconUrl: "https://raw.githubusercontent.com/fieldsjm/Resources/master/speaker.png",
    iconX2Url: "https://raw.githubusercontent.com/fieldsjm/Resources/master/speaker@2x.png",
    iconX3Url: "https://raw.githubusercontent.com/fieldsjm/Resources/master/speaker@3x.png")


preferences {
    // The parent app preferences are pretty simple: just use the app input for the child app.
    page(name: "mainPage", title: "Speaker Companion", install: true, uninstall: true,submitOnChange: true) {
        section {
            app(name: "speakerControl", appName: "Speaker Control", namespace: "smartThingsAPP", title: "Control - play/stop/pause/skip", required: true, multiple : false)
            app(name: "speakerNotify", appName: "Speaker Notify with Sound", namespace: "smartThingsAPP", title: "Play a notification", required: true, multiple : false)
            app(name: "weatherForecast", appName: "Speaker Weather Forecast", namespace: "smartThingsAPP", title: "Play weather report", required: true, multiple : false)
            }
    }
}

def installed() {
    log.debug "Installed with settings: ${settings}"
    initialize()
}

def updated() {
    log.debug "Updated with settings: ${settings}"
    unsubscribe()
    initialize()
}

def initialize() {
    // nothing needed here, since the child apps will handle preferences/subscriptions
    // this just logs some messages for demo/information purposes
    log.debug "there are ${childApps.size()} child smartapps"
    childApps.each {child ->
        log.debug "child app: ${child.label}"
    }
}
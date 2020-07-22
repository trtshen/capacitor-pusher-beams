import Foundation
import Capacitor
import PushNotifications

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(PusherBeams)
public class PusherBeams: CAPPlugin {
    let beamsClient = PushNotifications.shared
    
    @objc func echo(_ call: CAPPluginCall) {
        let value = call.getString("value") ?? ""
        print("echo func in iOS success!")
        call.success([
            "value": value
        ])
    }
    
    @objc func addDeviceInterest(_ call: CAPPluginCall) {
        let interest = call.getString("interest") ?? ""
        
        try? self.beamsClient.addDeviceInterest(interest: interest)
        call.success([
            "interest": interest
        ])
    }
    
    @objc func setDeviceInterests(_ call: CAPPluginCall) {
        guard let interests = call.options["interests"] as? [String] else {
            call.reject("Interests must be provided in array type")
            return
        }
        
        try? self.beamsClient.setDeviceInterests(interests: interests)
        call.success([
            "interests": interests
        ])
    }
    
    @objc func setUserId(_ call: CAPPluginCall) {
        let userId = call.getString("userId") ?? ""
        let tokenProvider = BeamsTokenProvider(authURL: "<YOUR_BEAMS_AUTH_URL_HERE>") { () -> AuthData in
          let sessionToken = "SESSION-TOKEN"
          let headers = ["Authorization": "Bearer \(sessionToken)"] // Headers your auth endpoint needs
          let queryParams: [String: String] = [:] // URL query params your auth endpoint needs
          return AuthData(headers: headers, queryParams: queryParams)
        }

        self.beamsClient.setUserId(userId, tokenProvider: tokenProvider, completion: { error in
          guard error == nil else {
              print(error.debugDescription)
              return
          }

          print("Successfully authenticated with Pusher Beams")
          call.success([
            "associatedUser": userId
          ])
        })
    }
    
    @objc func removeDeviceInterest(_ call: CAPPluginCall) {
        let interest = call.getString("interest") ?? ""
        try? self.beamsClient.removeDeviceInterest(interest: interest)
        call.success()
    }
    
    @objc func getDeviceInterests(_ call: CAPPluginCall) {
        let interests: [String] = self.beamsClient.getDeviceInterests() ?? []
        call.success([
            "interests": interests
        ])
    }
    
    @objc func clearDeviceInterests(_ call: CAPPluginCall) {
        try? self.beamsClient.clearDeviceInterests()
        call.success()
    }
}

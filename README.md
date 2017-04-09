# flickr-tests

Start appium server

Then you can start test by running command mvn test.
It's possible to pass following paramters from command line:

platformName - (iOS if not specified)
platformVersion - (9.3 if not specified)
deviceName - (iPhone 6 if not specified )

E.g. "mvn test -DplatformName=iOS -DplatformVersion=9.2 -DdeviceName=iPhone\ 6"

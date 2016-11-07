"""
Sample Test Case:
1. Launch URL www.themoneyhans.com
2. Click on "Fun Money Roof" URL
3. Validate Blog and Discussion section is displayed in Fun Money Roof page
4. Validate "Put your eggs in one basket" section is displayed with comments link. Click on arrow buttons for comments
5. Validate the image for eggs in one basket is displayed
6. Validate same image is available on API layer
7. Validate "Start discussions" text box is displayed at the bottom of the page
8. Validate Twitter, linked in, google plus and mail box options are available
9. Go to home page
10. Close the browser
"""

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import Select
from selenium.common.exceptions import NoSuchElementException
from selenium.common.exceptions import NoAlertPresentException
import unittest, time, re
import requests
from selenium.webdriver.firefox.firefox_binary import FirefoxBinary
import sys
from selenium import webdriver
from selenium.webdriver.firefox.firefox_binary import FirefoxBinary
from platform import platform, node
MAC = 0
#browser = sys.argv[1]


class SampleTest(unittest.TestCase):
    def setUp(self):
        if  MAC :
            binary_path = "C:\Program Files (x86)\Mozilla Firefox\firefox.exe"
            binary = FirefoxBinary(binary_path)
            self.driver = webdriver.Firefox(firefox_binary=binary,executable_path="C:\Gecko\geckodriver.exe") 
        else:
                #self.driver = webdriver.Remote(command_executor="http://192.168.56.1:5566/wd/hub",desired_capabilities={ "browserName": browser, "platform": platform, "node":node })
                #self.driver.implicitly_wait(2)
            edge_path = "E:\Softwares\Softwares\MicrosoftWebDriver.exe"
            self.driver = webdriver.Edge(edge_path);        

            #self.driver = webdriver.Chrome(executable_path="E:\chromedriver_win32\chromedriver.exe")
                #binary = FirefoxBinary("C:\Program Files (x86)\Mozilla Firefox\firefox.exe")
                #self.driver = webdriver.Firefox(firefox_binary=binary)
            #self.driver = webdriver.Firefox(executable_path="C:\Program Files (x86)\Mozilla Firefox\firefox.exe")
            
            #(executable_path="E:\chromedriver_win32\chromedriver.exe")
            #binary = FirefoxBinary('C:\Program Files (x86)\Mozilla Firefox\firefox.exe')
            #browser = webdriver.Firefox(firefox_binary=binary)
            #self.driver = webdriver.Firefox(firefox_binary=binary,executable_path="C:\Gecko\geckodriver.exe")
        self.driver.implicitly_wait(30)
        self.base_url = "http://themoneyhans.com/"
        self.verificationErrors = []
        self.accept_next_alert = True
    
    def test_untitled(self):
        driver = self.driver
        
        print "1. Launch URL www.themoneyhans.com"
        driver.get(self.base_url)
        print '2. Click on "Fun Money Roof" URL'
        driver.find_element_by_link_text("5.Fun Money Roof").click()
        print '3. Validate Blog and Discussion section is displayed in Fun Money Roof page'
        print "Making Sure headings appears on the page for Blogs and Discussions"
        page_headings = driver.find_elements_by_tag_name("h2")
        iteration =1
        while len(page_headings)<3:
            if iteration==5:
                print "Enough Blog , Discussion , Upcoming live events are not yet loaded. .."
                break;
            print "Perhaps , Blog , Dicussions and Upcoming events not yet loaded. "
            page_headings = driver.find_elements_by_tag_name("h2")
            iteration = iteration +1
            time.sleep(10)
            
        
        print "Assert Blog heading found"
        assert page_headings[0].text == "Blog"
        print "Assert Discussions heading found"
        assert page_headings[1].text == "Discussions"
        
        print "Checking for Blog sections again "
        assert page_headings[0].parent.find_element_by_class_name('col-md-8').find_element_by_tag_name('h2').text =="Blog"
        
        print "Check Articles inside blog , found"
        articles_inside_blog=page_headings[0].parent.find_elements_by_class_name('col-md-6')
        assert len(articles_inside_blog)>0
        
        print len(articles_inside_blog) , " found inside Blog section"
        
        print 'Check if discussions section populated '
        
        print "Check Discussions found"
        discussions = driver.find_element_by_id('discussion-nav').find_elements_by_tag_name('li')
        assert len(discussions)>0
        print len(discussions) , " found. "
        
        
        print '4. Validate "Put your eggs in one basket" section is displayed with comments link. Click on arrow buttons for comments'
        
        search_article ="WANT TO GET REALLY RICH? PUT YOUR EGGS IN ONE BASKET"
        found_article=[e for e in articles_inside_blog if e.text.strip().startswith(search_article)]

        print "Check if the article found, and only one such article"
        
        assert(len(found_article)==1)
        found_article=found_article[0]
        found_article.find_element_by_tag_name('img').click()
        print "5. Validate the image for eggs in one basket is displayed"
        image_for_web =  driver.find_element_by_xpath('//*[@title="WANT TO GET REALLY RICH? PUT YOUR EGGS IN ONE BASKET..."]')
        assert image_for_web
        img_path_web= image_for_web.get_attribute('src')
        #driver.find_element_by_class_name('img-responsive').get_attribute('src')

        print "6. Validate same image is available on API layer"
        resp_json=requests.get("http://themoneyhans.com/api/articles/url/put-your-eggs-in-one-basket...").json()
        
        img_path_api = self.base_url + resp_json['media']['path']
        img_resp= requests.get(img_path_api)
        print "Assert if image found ..."
        assert img_resp.status_code ==200
        
        assert img_path_web == img_path_api
        
        print "7. Validate Start Discussion in Comments section"
        disqus_iframe = driver.find_element_by_id('disqus_thread').find_element_by_tag_name('iframe')
        driver.switch_to.frame(disqus_iframe)
        driver.find_element_by_class_name('textarea-wrapper')
        assert driver.find_element_by_class_name('placeholder').text.strip()==u'Start the discussion\u2026'
        
        driver.find_element_by_class_name('textarea-wrapper')
        driver.find_element_by_class_name('textarea-wrapper').click() 
        driver.switch_to_default_content()
        
        print "8.Validate Twitter, linked in, google plus and mail box options are available"
        assert len([driver.find_element_by_class_name(e) for e in ['fa-google-plus','fa-twitter','fa-linkedin','fa-envelope']])==4

        print "9.Go to home page"
        driver.find_element_by_xpath('//*[@id="breadcam"]/ul/li[1]/a/img').click();

        print "10. Close the browser"
        driver.close();
        
    
    def is_element_present(self, how, what):
        try: self.driver.find_element(by=how, value=what)
        except NoSuchElementException as e: return False
        return True
    
    def is_alert_present(self):
        try: self.driver.switch_to_alert()
        except NoAlertPresentException as e: return False
        return True
    
    def close_alert_and_get_its_text(self):
        try:
            alert = self.driver.switch_to_alert()
            alert_text = alert.text
            if self.accept_next_alert:
                alert.accept()
            else:
                alert.dismiss()
            return alert_text
        finally: self.accept_next_alert = True
    
    def tearDown(self):
        self.driver.quit()
        self.assertEqual([], self.verificationErrors)

if __name__ == "__main__":
    unittest.main()

"""
    from multiprocessing import Pool
    suite = unittest.TestSuite()
    suite.addTest(SampleTest('test_something', 'my extra args'))
    unittest.TextTestRunner(verbosity=2).run(suite)

    #unittest.main()

""" 
"""
>> Selenium IDE for web driver installed.
>> pip install -U selenium   # For new versions few error fixed

http://stackoverflow.com/questions/37761668/cant-open-browser-with-selenium-after-firefox-update/37765661

1) Download geckodriver 0.6.2, unzip, rename to "wires" not "wires.exe" https://github.com/mozilla/geckodriver/releases

https://github.com/mozilla/geckodriver/releases
 
"""
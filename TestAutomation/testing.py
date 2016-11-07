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

from selenium import webdriver
from selenium.webdriver.firefox.firefox_binary import FirefoxBinary
MAC = 0
class SampleTest(unittest.TestCase):
    def setUp(self):
        if  MAC :
            binary_path = "C:\Program Files (x86)\Mozilla Firefox\firefox.exe"
            binary = FirefoxBinary(binary_path)
            self.driver = webdriver.Firefox(firefox_binary=binary,executable_path="C:\Gecko\geckodriver.exe") 
        else:
            self.driver = webdriver.Chrome(executable_path=r"C:\Python27\Scripts\chromedriver.exe")
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
        found_article=[e for e in articles_inside_blog if e.text.startswith(search_article)]
        print "Check if the article found, and only one such article"
        assert(len(found_article)==1)
        found_article=found_article[0]
        found_article.find_element_by_tag_name('img').click()
        print "5. Validate the image for eggs in one basket is displayed"
        image_for_web =  driver.find_element_by_css_selector('img.img-responsive.ng-scope')
        
        assert image_for_web
        img_path_web= image_for_web.get_property('src')

        print "6. Validate same image is available on API layer"
        resp_json=requests.get("http://themoneyhans.com/api/articles/url/put-your-eggs-in-one-basket...").json()
        
        img_path_api = self.base_url + resp_json['media']['path']
        img_resp= requests.get(img_path_api)
        print "Assert if image found ..."
        assert img_resp.status_code ==200
        'import pdb;pdb.set_trace()'
        assert img_path_web == img_path_api
          
#         search_article ="WANT TO GET REALLY RICH? PUT YOUR EGGS IN ONE BASKET"
#         found_article=[e for e in articles_inside_blog if e.text.startswith(search_article)]
#         print "Check if the article found, and only one such article"
#         assert(len(found_article)==1)
#         found_article=found_article[0]
#         
#         #assert page_headings[2].text == "Upcoming LiveEvent"
#         
#         driver.get(self.base_url + "/category/fun-money-roof")
#         driver.find_element_by_link_text("5.Fun Money Roof").click()
#         driver.find_element_by_css_selector("div.arrow-articale > a > img").click()
#         driver.find_element_by_css_selector("li > a > img").click()
    
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
>> Selenium IDE for web driver installed.
>> pip install -U selenium   # For new versions few error fixed

http://stackoverflow.com/questions/37761668/cant-open-browser-with-selenium-after-firefox-update/37765661

1) Download geckodriver 0.6.2, unzip, rename to "wires" not "wires.exe" https://github.com/mozilla/geckodriver/releases

https://github.com/mozilla/geckodriver/releases


 
 
"""
#pip install fabric
from fabric.api import local
import logging
logging.basicConfig(format='%(asctime)s %(message)s', datefmt='%m/%d/%Y %I:%M:%S %p',
                        filename="command.log", level=logging.DEBUG)
#logger.setLevel(logging.WARNING)

commands =  ["galen test Cross_Browser.test --htmlreport results",
             "python testing.py",
             "python testingedge.py" e            
             ]

for comamnd in commands :
    try:
        logging.debug("Logging command %s"%comamnd)
        local(comamnd)
        logging.info("Command executed command %s"%comamnd)
        
    except:
        logging.error("Error  executing command %s"%comamnd)
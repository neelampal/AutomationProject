#pip install fabric
from fabric.api import local
import logging
logging.basicConfig(format='%(asctime)s %(message)s', datefmt='%m/%d/%Y %I:%M:%S %p',
                        filename="command_multiprocessing.log", level=logging.DEBUG)
#logger.setLevel(logging.WARNING)
from multiprocessing import Pool
POOL_SIZE=5
commands =  ["python testing.py", 
             "python testingedge.py",
             "python testingfirefox.py",
             ]

def run_command(comamnd):
    try:
        logging.debug("Logging command %s"%comamnd)
        local(comamnd)
        logging.info("Command executed command %s"%comamnd)
        
    except:
        logging.error("Error  executing command %s"%comamnd)
    

if __name__ == '__main__':
    p = Pool(POOL_SIZE)
    print(p.map(run_command, commands))
    
        
    
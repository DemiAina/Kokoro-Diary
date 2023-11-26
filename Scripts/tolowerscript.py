import os 
# os replace

current_dir = os.getcwd()

files = []
for root,dirs , files in os.walk(current_dir):
    for (current_dir, dir_names , file_names) in os.walk(current_dir):
        files.extend(file_names)

for root,dirs , files in os.walk(current_dir):
    for (current_dir, dir_names , file_names) in os.walk(current_dir):
        for i in files:
            os.renames(i, i.lower())
print(files)


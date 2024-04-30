
# # #
# Makefile to compile Scala source files
# Learning to walk before we run
# by avoiding learning build tools like sbt.
# # #

SCALAC = scalac
SRC_DIR = src
OUT_DIR = .

SRCS = $(wildcard $(SRC_DIR)/*.scala)
OBJS = $(patsubst $(SRC_DIR)/%.scala, $(OUT_DIR)/%.class, $(SRCS))

.PHONY: all clean

all: $(OBJS)

$(OUT_DIR)/%.class: $(SRC_DIR)/%.scala
	@mkdir -p $(OUT_DIR)
	$(SCALAC) -d $(OUT_DIR) $<

clean:
	rm -rf $(OUT_DIR)/*.class

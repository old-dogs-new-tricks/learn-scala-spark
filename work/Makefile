SCALAC = scalac
SRC_DIR = src
OUT_DIR = out

SRCS = $(wildcard $(SRC_DIR)/*.scala)
OBJS = $(patsubst $(SRC_DIR)/%.scala, $(OUT_DIR)/%.class, $(SRCS))

.PHONY: all clean

all: $(OBJS)

$(OUT_DIR)/%.class: $(SRC_DIR)/%.scala
	@mkdir -p $(OUT_DIR)
	$(SCALAC) -d $(OUT_DIR) $<

clean:
	rm -rf $(OUT_DIR)

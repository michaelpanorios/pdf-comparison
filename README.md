## Capabilities:

-The script proceeds to a visualized comparison in which files are rendered and compared pixel by pixel. This will produce an output PDF which may include markings for differences found. Firstly, it renders a page from the expected.pdf and the same page from the actual.pdf to a bitmap image and compares these two images pixel by pixel. Pixels that are equal are faded a bit. Pixels that differ are marked in red and green. Green for pixels that where in the expected.pdf, but are not present in the actual.pdf. Red for pixels that are present in the actual.pdf, but were not in the expected.

-Simultaneously, the script extracts file's content to simple text and finds all the differences between these. This will produce a console output with all the differences that have been recorded. This utility expose the differences in detail which may not be clear to see in the exported differences.pdf .
